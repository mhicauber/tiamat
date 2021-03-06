DROP TABLE IF EXISTS id_generator;
CREATE TABLE id_generator(table_name VARCHAR (50), id_value bigint, CONSTRAINT id_constraint UNIQUE (table_name, id_value));

CREATE index stop_place_netex_id_index ON stop_place(netex_id);
CREATE index stop_place_version_index ON stop_place(version);
CREATE index quay_netex_id_index ON quay(netex_id);
CREATE index quay_version_index ON quay(version);
CREATE index table_name_index ON id_generator(table_name);
CREATE index id_value_index ON id_generator(id_value);
CREATE index value_id_index ON value_items (value_id);
