/* DELETE FROM cms_db.customer where customer_id='123456787' */

/*enable cascade delete to account table*/

-- ALTER TABLE cms_db.account 
-- ADD CONSTRAINT `FK_customer_account` 
-- FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) 
-- ON DELETE CASCADE; 

-- ALTER TABLE cms_db.card_details 
-- ADD CONSTRAINT `FK_customer_card_details` 
-- FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) 
-- ON DELETE CASCADE; 

