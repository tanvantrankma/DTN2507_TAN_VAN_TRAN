-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS Trg_BfInsertGroup;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertGroup
    BEFORE INSERT ON `Group`
    FOR EACH ROW
    BEGIN		
		IF NEW.CreateDate <=  DATE_SUB(now(), INTERVAL 1 YEAR) THEN
			SIGNAL SQLSTATE '54312'
            SET MESSAGE_TEXT = 'KHONG THEM DUOC QUESTION 1';
		END IF;
    END$$
DELIMITER ;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"

DROP TRIGGER IF EXISTS Trg_BfInsertAccountCheckDep_Sale;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertAccountCheckDep_Sale
   BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN	
		DECLARE v_DepartmentName VARCHAR(50);
		SELECT DepartmentName INTO v_DepartmentName FROM Department WHERE DepartmentID = 'Sale';
		IF NEW.DepartmentID = v_DepartmentName THEN
        SIGNAL SQLSTATE '53312'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
    END$$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS Trg_BfInserUser_GroupAccount_max5;
DELIMITER $$
	CREATE TRIGGER Trg_BfInserUser_GroupAccount_max5
    BEFORE INSERT ON GroupAccount
    FOR EACH ROW
    BEGIN		
		DECLARE v_group_has_5_or_more_members BIT;
        SET v_group_has_5_or_more_members = (
        SELECT COUNT(GroupID) > 5 FROM GroupAccount WHERE GroupID = NEW.GroupID
        );
        
        IF (v_group_has_5_or_more_members) THEN
			SIGNAL SQLSTATE '53313'
            SET MESSAGE_TEXT = 'Unable to insert account to group, groups must have no more than 5 members';
    END IF;
    END$$
DELIMITER ;

INSERT INTO `groupaccount` (`GroupID`, `AccountID`, `JoinDate`) VALUES ('3', '5', now());

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS Trg_BfInsertExamQuestion_Max10;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertExamQuestion_Max10
    BEFORE INSERT ON ExamQuestion
    FOR EACH ROW
    BEGIN
		DECLARE v_exam_has_10_or_more_questions INT;
		SELECT COUNT(ExamiD) INTO v_exam_has_10_or_more_questions FROM ExamQuestion WHERE ExamID = NEW.ExamID;
		IF v_exam_has_10_or_more_questions > 1 THEN
			SIGNAL SQLSTATE '53413'
            SET MESSAGE_TEXT = 'Exam already has 10 or more questions, cannot add more questions to exam';
    END IF;
    END$$
DELIMITER ;

INSERT INTO `examquestion`(`ExamID`, `QuestionID`) VALUES (6, 3);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó


DROP TRIGGER IF EXISTS Trg_BfDelete_Account;
DELIMITER $$
	CREATE TRIGGER Trg_BfDelete_Account
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN		
		DECLARE v_Email VARCHAR(50);
        SET v_Email = 'admin@gmail.com';
        IF	OLD.Email = v_Email THEN
			SIGNAL SQLSTATE '55513'
            SET MESSAGE_TEXT = 'khong xoa duoc';
		END IF;
    END$$
DELIMITER ;
INSERT INTO `account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`) VALUES ('admin@gmail.com', 'tuantran', 'Trần Văn Tuấn', '1', '2');

DELETE FROM `account` WHERE Email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_BfInsertAccount_null;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertAccount_null
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN		
		-- DECLARE v_DepartmentID = 'waiting Department';
        
        IF NEW.DepartmentID IS NULL THEN
			-- SELECT d.DepartmentID INTO v_DepartmentID FROM department d WHERE DepartmentID = 'waiting Department';
            SET NEW.DepartmentID = 'waiting Department';
    END IF;
    END$$
DELIMITER ;

INSERT INTO `account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
VALUES ('tanvantrankma@gmail.com',	 'tantantan', 		'Tran Van Taan', 		'1', '2019-07-15 00:00:00');


ALTER TABLE `Account`
MODIFY COLUMN DepartmentID INT NULL;



DROP TRIGGER IF EXISTS Trg_SetDepWaittingRoom;
DELIMITER $$
CREATE TRIGGER Trg_SetDepWaittingRoom
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
		DECLARE v_WaittingRoom VARCHAR(50);
        SELECT D.DepartmentID INTO v_WaittingRoom FROM department D WHERE D.DepartmentName = 'Waitting Room';
		IF (NEW.DepartmentID IS NULL ) THEN
			SET NEW.DepartmentID = v_WaittingRoom;
        END IF;
END $$
DELIMITER ;

INSERT INTO `testingsystem`.`account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
									VALUES ('1',	 '1', 		'1', 		'1', 		'2019-07-15 00:00:00');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database






















