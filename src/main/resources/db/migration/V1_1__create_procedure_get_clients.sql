CREATE OR REPLACE FUNCTION get_clients(
    page_number INT,
    page_size INT
)
RETURNS TABLE (
    id BIGINT,
    first_name VARCHAR,
    last_name VARCHAR,
    dni VARCHAR,
    status VARCHAR,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
)
LANGUAGE plpgsql
AS $$
DECLARE
the_offset INT;
BEGIN
    -- Calcular el offset
    the_offset := (page_size * page_number) - page_size;

    -- Devolver los resultados directamente
RETURN QUERY
SELECT
    c1.id, c1.first_name, c1.last_name, c1.dni, c1.status, c1.created_at, c1.updated_at
FROM
    client_projections c1
        JOIN (
        SELECT c2.id
        FROM client_projections c2
        ORDER BY c2.last_name, c2.first_name
            LIMIT page_size OFFSET the_offset
    ) AS c3 ON c1.id = c3.id;
END;
$$;
