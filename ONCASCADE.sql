-- DELETE FROM cms_db.customer where customer_id='1234567895'; 

/*enable cascade delete to account table*/

-- ALTER TABLE cms_db.account 
-- ADD CONSTRAINT `FK_customer_account` 
-- FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) 
-- ON DELETE CASCADE; 

-- ALTER TABLE cms_db.card_details 
-- ADD CONSTRAINT `FK_customer_card_details` 
-- FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) 
-- ON DELETE CASCADE;

-- ALTER TABLE cms_db.account DROP FOREIGN KEY FK_customer_account;
-- ALTER TABLE cms_db.card_details DROP FOREIGN KEY FK_customer_card_details; 


-- ALTER TABLE cms_db.account
-- ADD CONSTRAINT FK_customer_account
-- FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
-- ON DELETE CASCADE;

-- ALTER TABLE cms_db.card_details
-- ADD CONSTRAINT FK_customer_card_details
-- FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
-- ON DELETE CASCADE;



-- this will indicate the enabled constrained & delet rule 

-- SELECT
--     table_name,
--     constraint_name,
--     delete_rule
-- FROM
--     information_schema.REFERENTIAL_CONSTRAINTS
-- WHERE
--     constraint_schema = 'cms_db'
--     AND table_name IN ('account', 'card_details');



-- ALTER TABLE cms_db.card_details DROP FOREIGN KEY FK96j0ltqg58luswf0ykdf6kobr;
-- ALTER TABLE cms_db.account DROP FOREIGN KEY FKnnwpo0lfq4xai1rs6887sx02k;