package org.rutebanken.tiamat.repository;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class PathLinkRepositoryImpl implements PathLinkRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    public Long findByKeyValue(String key, Set<String> values) {

        Query query = entityManager.createNativeQuery("SELECT path_link_id " +
                "FROM path_link_key_values plkv " +
                "INNER JOIN value_items v " +
                "ON plkv.key_values_id = v.value_id " +
                "WHERE  plkv.key_values_key = :key " +
                "AND v.items IN ( :values ) ");

        query.setParameter("key", key);
        query.setParameter("values", values);

        try {
            @SuppressWarnings("unchecked")
            List<BigInteger> results = query.getResultList();
            if (results.isEmpty()) {
                return null;
            } else {
                return results.get(0).longValue();
            }
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    @Override
    public List<Long> findByStopPlaceNetexId(String netexStopPlaceId) {

        String sql = "SELECT pl.id " +
                "FROM path_link pl " +
                "       INNER JOIN path_link_end ple " +
                "               ON pl.from_id = ple.id " +
                "                  OR pl.to_id = ple.id " +
                "       INNER JOIN quay q " +
                "               ON q.id = ple.quay_id " +
                "WHERE q.id IN (SELECT spq.quays_id " +
                "                FROM stop_place_quays spq " +
                "                   INNER join stop_place s on s.id = spq.stop_place_id " +
                "                WHERE s.netex_id = :netexStopPlaceId)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("netexStopPlaceId", netexStopPlaceId);

        try {
            @SuppressWarnings("unchecked")
            List<BigInteger> results = query.getResultList();
            return results.stream()
                    .map(bigInteger -> bigInteger.longValue())
                    .collect(toList());

        } catch (NoResultException noResultException) {
            return new ArrayList<>();
        }
    }
}
