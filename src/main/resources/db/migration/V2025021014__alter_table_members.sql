ALTER TABLE members
ADD COLUMN role_id BIGINT,
ADD COLUMN password VARCHAR(255),
ADD COLUMN email VARCHAR(255),
ADD CONSTRAINT fk_members_role
    FOREIGN KEY (role_id)
    REFERENCES roles(id)