CREATE SEQUENCE  IF NOT EXISTS municipality_part_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE municipality_part (
  id INTEGER NOT NULL,
   code VARCHAR(255) NOT NULL,
   name VARCHAR(255) NOT NULL,
   main_municipality INTEGER,
   created_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_municipality_part PRIMARY KEY (id)
);

ALTER TABLE municipality_part ADD CONSTRAINT uc_municipality_part_code UNIQUE (code);

ALTER TABLE municipality_part ADD CONSTRAINT FK_MUNICIPALITY_PART_ON_MAIN_MUNICIPALITY FOREIGN KEY (main_municipality) REFERENCES municipality (id);