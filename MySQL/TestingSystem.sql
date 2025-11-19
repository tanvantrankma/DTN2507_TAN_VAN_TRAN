CREATE DATABASE Data;
USE Data;

-- Table 1
CREATE TABLE Department (
	DepartmentID			INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName			VARCHAR(255) NOT NULL
    -- PRIMARY KEY DepartmentID
);

INSERT INTO Department (DepartmentName) VALUES 
	('Sale'),
    ('Tai Chinh'),
    ('Nhan Su'),
    ('Giam Doc'),
    ('Phong Ky Thuat'),
    ('Pho Giam Doc'),
    ('Phong Kinh Doanh'),
    ('Marketing'),
    ('Ke Toan'),
    ('Ke Toan');

-- Table 2    
CREATE TABLE Position (
	PositionID 				INT AUTO_INCREMENT PRIMARY KEY,
    PositionName 			VARCHAR(255) NOT NULL
);
-- ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NUM;
INSERT INTO Position (PositionName) VALUES
('Dev'),
('Test'),
('Scrum Master'),
('PM'),
('Editor'),
('Mentor'),
('Admin'),
('Assistant'),
('Intern'),
('Leader');

-- Table 3
drop table account;
CREATE TABLE Account (
	AccountID 		INT AUTO_INCREMENT PRIMARY KEY,
    Email 			VARCHAR(255) NOT NULL UNIQUE KEY,
    Username 		VARCHAR(255) NOT NULL UNIQUE KEY,
    DepartmentID 	INT NOT NULL,
    PositionID 		INT NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
	FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES Position (PositionID)
);

-- ALTER TABLE Account -- DepartmentID  
-- ADD FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID);

INSERT INTO Account (Email, Username, DepartmentID, PositionID) VALUES
('tantran@gmail.com', 'tanvantran','2','3'),
('thaotran@gmail.com', 'thaotran', '3', '2'),
('huyxa@gmail.com', 'huydo','5', '6'),
('tuananh@gmail.com', 'tuananh','2','1'),
('linhdo@gmail.com', 'linhdo','1','1'),
('hoale@gmail.com', 'lehoa','5','5'),
('ducpham@gmail.com', 'phamduc','8','8'),
('phanhuyen@gmail.com', 'huyenphan','9','1'),
('xuanlan@gmail.com', 'xuanlan','4','7'),
('kienho@gmail.com', 'hokien','10','4');

-- Table 4
DROP TABLE IF EXISTS `Group`;
CREATE TABLE Groupp (
	GroupID 		INT AUTO_INCREMENT PRIMARY KEY,
    GroupName 		VARCHAR(255) NOT NULL UNIQUE KEY,
    CreatorID 		INT,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) REFERENCES Account(AccountID)
);

INSERT INTO Groupp (GroupName, CreatorID) VALUES
('Gr 01', '1'),
('Gr 03', '7'),
('Gr 02', '7'),
('Gr 06', '3'),
('Gr 05', '2'),
('Gr 07', '2'),
('Gr 08', '6'),
('Gr 09', '9'),
('Gr 04', '5'),
('Gr 11', '2');


-- Table 5
CREATE TABLE GroupAccount (
	GroupID 		INT NOT NULL,
    AccountID 		INT,
    JoinDate 		DATETIME DEFAULT NOW()
    -- PRIMARY KEY(GroupID,AccountID),
    -- FOREIGN KEY(GroupID) REFERENCES Groupp (GroupID)
);


ALTER TABLE GroupAccount
ADD FOREIGN KEY (GroupID) REFERENCES Groupp (GroupID);

ALTER TABLE GroupAccount
ADD FOREIGN KEY (AccountID) REFERENCES Account (AccountID);

INSERT INTO GroupAccount (GroupID, AccountID) VALUES
('1', '2'),
('3', '2'),
('1', '6'),
('5', '4'),
('7', '8'),
('9', '10'),
('1', '3'),
('5', '5'),
('5', '6'),
('4', '8'),
('9', '2');

-- Table 6
DROP TABLE TypeQuestion;
CREATE TABLE TypeQuestion (
	TypeID 			INT AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('Essay','Multiple-Choice', 'Essay-01','Essay-02', 'Essay-03', 'Essay-04', 'Essay-05', 'Multiple-Choice-01', 'Multiple-Choice-03', 'Multiple-Choice-02') NOT NULL UNIQUE KEY
);

INSERT INTO TypeQuestion (TypeName) VALUES
('Essay'),
('Multiple-Choice'),
('Essay-01'),
('Multiple-Choice-01'),
('Essay-02'),
('Essay-03'),
('Multiple-Choice-02'),
('Multiple-Choice-03'),
('Essay-04'),
('Essay-05');

-- Table 7
CREATE TABLE CategoryQuestion (
	CategoryID 		INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName 	VARCHAR(255) NOT NULL UNIQUE KEY
);

INSERT INTO CategoryQuestion (CategoryName) VALUES
('Java'),
('C++'),
('C#'),
('.NET'),
('Postman,'),
('SQL'),
('Ruby'),
('Python'),
('BE'),
('Golang');

-- Table 8
CREATE TABLE Question (
	QuestionID 		INT AUTO_INCREMENT PRIMARY KEY,
    Content 		VARCHAR(255) NOT NULL,
    CategoryID 		INT NOT NULL,  -- CategoryQuestion
    TypeID 			INT NOT NULL, -- TypeQuestion
    CreatorID 		INT NOT NULL, -- Groupp
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) REFERENCES Account(AccountID)
);


INSERT INTO Question (Content, CategoryID, TypeID, CreatorID) VALUES
('Content-01','2','3','4'),
('Content-02','3','3','5'),
('Content-03','8','7','9'),
('Content-04','2','5','1'),
('Content-01','6','7','2'),
('Content-06','7','7','7'),
('Content-08','9','8','9'),
('Content-09','1','1','6'),
('Content-10','6','7','8'),
('Content-11','5','3','3');


-- Table 9
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID 		INT AUTO_INCREMENT PRIMARY KEY,
    Content 		VARCHAR(255) NOT NULL,
    QuestionID 		INT NOT NULL,
    isCorrect 		BOOLEAN, -- BIT DEFAULT 1,
    FOREIGN 		KEY(QuestionID) REFERENCES Question(QuestionID)
); 

INSERT INTO Answer (Content, QuestionID, isCorrect) VALUES
('Content-01', '2', '0'),
('Content-02', '5', '0'),
('Content-03', '8', '1'),
('Content-04', '2', '0'),
('Content-05', '9', '1'),
('Content-06', '7', '0'),
('Content-07', '9', '0'),
('Content-08', '1', '0'),
('Content-09', '10', '1'),
('Content-10', '8', '1');

-- Table 10
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID 			INT AUTO_INCREMENT PRIMARY KEY,
    Code 			VARCHAR(255) NOT NULL UNIQUE KEY,
    Title 			VARCHAR(255) NOT NULL UNIQUE KEY,
    CategoryID 		INT NOT NULL, -- 
    Duration 		INT NOT NULL,
    CreatorID 		INT NOT NULL, -- 
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) REFERENCES Account(AccountID)
);

INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID) VALUES
('MD01', 'Chude-01','3','60','2'),
('MD02', 'Chude-02', '5','90','1'),
('MD03', 'Chude-03', '4','120','2'),
('MD04', 'Chude-10', '6','180','5'),
('MD05', 'Chude-09', '7','60','6'),
('MD06', 'Chude-08', '9','90','9'),
('MD07', 'Chude-07', '8','90','1'),
('MD08', 'Chude-06', '10','120','9'),
('MD09', 'Chude-05', '1','90','7'),
('MD10', 'Chude-04', '2','60','4');

-- Table 11
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
	ExamID 			INT NOT NULL,
    QuestionID 		INT NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
    -- PRIMARY KEY (ExamID,QuestionID)
);

INSERT INTO ExamQuestion (ExamID, QuestionID) VALUES
('2', '1'),
('3', '5'),
('7', '9'),
('10', '1'),
('2', '4'),
('6', '8'),
('5', '3'),
('4', '1'),
('7', '7'),
('9', '8'),
('4', '5');


-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM data.Department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT	DepartmentID FROM data.Department WHERE DepartmentName = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM data.Account WHERE length(UserName) = (SELECT MAX(length(UserName)) FROM data.Account);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM data.Account WHERE length(UserName) = (SELECT MAX(length(UserName)) FROM data.Account) AND AccountID = '3';

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * FROM data.Groupp WHERE CreateDate < '2025/10/23';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID FROM data.Answer GROUP BY QuestionID HAVING COUNT(AnswerID) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT Code FROM data.Exam WHERE Duration > '90' AND CreateDate < '2025/10/23';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT GroupName FROM data.Groupp ORDER BY CreateDate DESC LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(PositionID) FROM data.Account WHERE DepartmentID = '2';

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT UserName FROM data.Account WHERE UserName LIKE 'T%n';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM data.Exam WHERE CreateDate < '2019/12/20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM data.Question WHERE Content LIKE 'Cau hoi%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE Account
SET UserName = 'nguyenbaloc',
	Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = '9';

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE GrouppAccount
SET GroupID = '4'
WHERE AccountID = '5';



















































































