CREATE OR REPLACE FUNCTION get_accounts(
    page_number INT,
    page_size INT
)
RETURNS TABLE (
    id BIGINT,
    number VARCHAR,
    balance NUMERIC,
    overdraft_limit NUMERIC,
    client_id INT,
    client_dni VARCHAR,
    client_name VARCHAR,
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
    a1.id, a1.number, a1.balance, a1.overdraft_limit,
    a1.client_id, a1.client_dni, a1.client_name,
    a1.created_at, a1.updated_at
FROM
    account_projections a1
        JOIN (
        SELECT a2.id
        FROM account_projections a2
        ORDER BY a2.created_at
            LIMIT page_size OFFSET the_offset
    ) AS a3 ON a1.id = a3.id;
END;
$$;
