-- Create store procedure: cú pháp
-- DROP PROCEDURE IF EXISTS procedure_name();
-- DELIMITER $$ 	(hoặc DELIMITER //)
-- CREATE PROCEDURE procedure_name (IN in_param_name_1 Datatype, OUT out_param_name_2 Datatype)
-- 			BEGIN
-- 				SELECT …;
-- 				END$$
-- DELIMITER ;

-- CALL procedure_name();

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó

USE TestingSystem;

DROP PROCEDURE IF EXISTS sp_getAccountByDepID;
DELIMITER $$ 
CREATE PROCEDURE sp_getAccountByDepID ()
			BEGIN
				SELECT * FROM Account WHERE DepartmentID = 1;
			END$$
DELIMITER ;
CALL sp_getAccountByDepID();

SELECT 
	d.DepartmentID, 
	d.DepartmentName,
    a.UserName 
FROM Department d 
INNER JOIN Account a 
	ON d.DepartmentID = a.DepartmentID;
    

DROP PROCEDURE IF EXISTS sp_getAccountByDepartID;
DELIMITER $$ 
CREATE PROCEDURE sp_getAccountByDepartID (IN in_DepartID INT)
			BEGIN
				SELECT * FROM Account WHERE DepartmentID = in_DepartID;
			END$$
DELIMITER ;
CALL sp_getAccountByDepartID(2);

DROP PROCEDURE IF EXISTS sp_getAccountByDepart2ID;
DELIMITER $$ 
CREATE PROCEDURE sp_getAccountByDepart2ID (IN in_DepartID INT, OUT out_count INT)
			BEGIN
				SELECT COUNT(1) INTO out_count FROM Account WHERE DepartmentID = in_DepartID;
			END$$
DELIMITER ;
-- khai báo biến
SET @v_Count = 0;
CALL sp_getAccountByDepart2ID(2,@v_Count);

SELECT @v_Count;

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

DROP PROCEDURE IF EXISTS sp_getAccountByGroup;
DELIMITER $$ 	
CREATE PROCEDURE sp_getAccountByGroup ()
			BEGIN
				SELECT 
					gr.GroupID, 
                    COUNT(*) AS SoLuongAccount 
				FROM GroupAccount gr 
				GROUP BY gr.GroupID 
				ORDER BY COUNT(gr.GroupID) DESC;
				END$$
DELIMITER ;

-- SELECT gr.GroupID, COUNT(*) AS SoLuongAccount FROM GroupAccount gr 
-- GROUP BY gr.GroupID 
-- ORDER BY COUNT(gr.GroupID) DESC;

CALL sp_getAccountByGroup();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại

DROP PROCEDURE IF EXISTS sp_getTypeByQuestion;
DELIMITER $$ 
CREATE PROCEDURE sp_getTypeByQuestion ()
			BEGIN
				WITH cte_TypeByQuestion AS (
				SELECT 
					tq.TypeID, 
					tq.TypeName,
					q.QuestionID,
					q.Content, 
					q.CreateDate
				FROM TypeQuestion tq
				INNER JOIN Question q 
					ON tq.TypeID = q.TypeID
				WHERE MONTH(q.CreateDate) = MONTH(CURDATE()) AND
						YEAR(q.CreateDate) = YEAR(CURDATE())
			)

				SELECT 
					TypeName, 
					COUNT(QuestionID) AS SoLuongTaoMONTH 
				FROM cte_TypeByQuestion
				GROUP BY TypeName
				ORDER BY COUNT(QuestionID) DESC;
			END$$
DELIMITER ;

-- WITH cte_TypeByQuestion AS (
-- 	SELECT 
-- 		tq.TypeID, 
--         tq.TypeName,
--         q.QuestionID,
-- 		q.Content, 
-- 		q.CreateDate
-- 	FROM TypeQuestion tq
-- 	INNER JOIN Question q 
-- 		ON tq.TypeID = q.TypeID
-- 	WHERE MONTH(q.CreateDate) = MONTH(CURDATE()) AND
-- 			YEAR(q.CreateDate) = YEAR(CURDATE())
-- )

-- SELECT 
-- 	TypeName, 
-- 	COUNT(QuestionID) AS SoLuongTaoMONTH 
-- FROM cte_TypeByQuestion
-- GROUP BY TypeName
-- ORDER BY COUNT(QuestionID) DESC;

CALL sp_getTypeByQuestion();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS sp_TypeQuestionMax_Q4;
DELIMITER $$ 
CREATE PROCEDURE sp_TypeQuestionMax_Q4 ()
			BEGIN
				WITH cte_maxCountTypeID AS (
					SELECT COUNT(*) AS SL FROM Question q 
					GROUP BY q.TypeID
					)

				SELECT tq.TypeID, COUNT(q.TypeID) SoLuongMAXX FROM  Question q 
				INNER JOIN TypeQuestion tq 
					ON q.TypeID = tq.TypeID
				GROUP BY q.TypeID
				HAVING COUNT(q.TypeID) = (SELECT MAX(SL) AS SoLuongMaxType FROM cte_maxCountTypeID);
			END$$
DELIMITER ;

CALL sp_TypeQuestionMax_Q4();

-- WITH cte_maxCountTypeID AS (
-- 	SELECT COUNT(*) AS SL FROM Question q 
-- 	GROUP BY q.TypeID
-- )

-- SELECT tq.TypeID, COUNT(q.TypeID) SoLuongMAXX FROM  Question q 
-- INNER JOIN TypeQuestion tq 
-- 	ON q.TypeID = tq.TypeID
-- GROUP BY q.TypeID
-- HAVING COUNT(q.TypeID) = (SELECT MAX(SL) AS SoLuongMaxType FROM cte_maxCountTypeID);

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS sp_getTypeName;
DELIMITER $$ 	
CREATE PROCEDURE sp_getTypeName (OUT out_TypeID INT, OUT out_TypeName VARCHAR(20))
			BEGIN
				WITH cte_maxCountTypeID AS (
					SELECT COUNT(*) AS SL FROM Question q 
					GROUP BY q.TypeID
					)

				SELECT 
					tq.TypeID, 
                    tq.TypeName
				INTO out_TypeID, out_TypeName
				FROM  Question q 
				INNER JOIN TypeQuestion tq 
					ON q.TypeID = tq.TypeID
				GROUP BY q.TypeID
				HAVING COUNT(q.TypeID) = (SELECT MAX(SL) AS SoLuongMaxType FROM cte_maxCountTypeID);
				END$$
DELIMITER ;

SET @v_IDType = 0;
SET @v_NameType = '';

CALL sp_getTypeName(@v_IDType, @v_NameType);
SELECT @v_IDType, @v_NameType;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào

DROP PROCEDURE IF EXISTS sp_Question_6;
DELIMITER $$ 
CREATE PROCEDURE sp_Question_6 (IN in_string VARCHAR(50))
			BEGIN
				SELECT GroupName AS ReturnName FROM `Group` g
				WHERE g.GroupName LIKE CONCAT('%',in_String,'%')
				UNION ALL
				SELECT UserName AS ReturnName FROM Account ac
				WHERE ac.UserName LIKE CONCAT('%', in_string, '%');
				END$$
DELIMITER ;

-- SELECT GroupName FROM `Group` g
-- WHERE g.GroupName LIKE CONCAT('%',in_String,'%')
-- UNION ALL
-- SELECT UserName FROM Account ac
-- WHERE ac.UserName LIKE CONCAT('%', in_string, '%');

CALL sp_Question_6('van');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
	-- username sẽ giống email nhưng bỏ phần @..mail đi
	-- positionID: sẽ có default là developer
	-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS sp_Question_7;
DELIMITER $$ 	
CREATE PROCEDURE sp_Question_7 (IN in_FullName VARCHAR(50), IN in_Email VARCHAR(50))
			BEGIN
				DECLARE v_UserName VARCHAR(50);
                DECLARE v_PositionID INT;
                DECLARE v_DepartmentID INT;
                
				SELECT SUBSTRING_INDEX(in_Email,'@',1) INTO v_UserName;
				SELECT PositionID INTO v_PositionID FROM Position
				WHERE PositionName = 'Dev' LIMIT 1;
				SELECT d.DepartmentID INTO v_DepartmentID FROM Department d
                -- INNER JOIN Department d ON a.DepartmentID = d.DepartmentID
				WHERE d.DepartmentName = 'Sale' LIMIT 1;
                
                INSERT INTO Account (Email, UserName, FullName, DepartmentID, PositionID, CreateDate)
                VALUES 	            (in_Email, v_UserName, in_FullName, v_DepartmentID, v_PositionID, NOW());
				SELECT CONCAT(v_UserName, ' ', v_PositionID , ' ', v_DepartmentID) AS KETQUA;
				END$$
DELIMITER ;

CALL sp_Question_7('Tran Van Tan','tantrantan@gmail.com');
CALL sp_Question_7('Nuyen Quang Dao', 'Daonguyen@gmail.com');
CALL sp_Question_7('Hoang Minh Đạt', 'DatHoang@gmail.com');


SELECT v_UserName = (SUBSTRING_INDEX(in_Email,'@',1);
SELECT PositionID INTO v_PositionID FROM Position
WHERE PositionName = 'Developer';
SELECT DepartmentID INTO v_DepartmentID FROM Department
WHERE DepartmentName = 'Phòng chờ';
SELECT CONCAT(v_UserName , v_PositionID , v_DepartmentID) AS KETQUA;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS sp_Question_8;
DELIMITER $$ 	
CREATE PROCEDURE sp_Question_8 (IN in_string VARCHAR(50))
			BEGIN
				WITH cte_maxCon AS(
				SELECT q.Content AS maxSL FROM Question q
				-- WHERE q.TypeName = in_String
				)
				SELECT q.questionID, q.Content, tq.TypeName, LENGTH(q.Content) AS MAXcontent FROM TypeQuestion tq 
				INNER JOIN Question q 
					ON tq.TypeID = q.TypeID
				WHERE tq.TypeName = in_String 
				-- AND	LENGTH(q.Content) = (SELECT MAX(maxSL) AS QLM FROM cte_maxCon) ;
				ORDER BY LENGTH(q.Content) DESC;
				END$$
DELIMITER ;

CALL sp_Question_8('essay');

-- WITH cte_maxCon AS(
-- SELECT COUNT(*) AS maxSL FROM Question q
-- WHERE LENGTH(q.Content)
-- )
-- SELECT q.questionID, q.Content, LENGTH(q.Content) AS MAXcontent FROM TypeQuestion tq 
-- INNER JOIN Question q 
-- 	ON tq.TypeID = q.TypeID
-- WHERE TypeName = in_String
-- AND COUNT(LENGTH(q.Content)) = (SELECT MAX(maxSL) AS QLM FROM cte_maxCon);
-- -- ORDER BY LENGTH(q.Content) DESC;

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

DROP PROCEDURE IF EXISTS sp_Question_9;
DELIMITER $$ 	
CREATE PROCEDURE sp_Question_9 (IN in_ExamID INT)
			BEGIN
				DELETE FROM Exam e
				WHERE e.ExamID = in_ExamID;
				END$$
DELIMITER ;

CALL sp_Question_9();

DELETE FROM Exam e
WHERE e.ExamID = in_ExamID

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing

DROP PROCEDURE IF EXISTS SP_Question_10();
DELIMITER $$ 
CREATE PROCEDURE SP_Question_10 ()
			BEGIN
				SELECT …;
				END$$
DELIMITER ;

CALL SP_Question_10();

WITH cte_ExamID AS (
	SELECT ExamID FROM Exam 
	WHERE CreateDate < '2022/10/31'
)







































































































