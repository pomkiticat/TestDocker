FROM postgres
COPY createTable.sql /docker-entrypoint-initdb.d/