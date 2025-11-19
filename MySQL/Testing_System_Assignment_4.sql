USE TestingSystem;
-- Testing_System_Asignment_4
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ

SELECT 
	a.AccountID, a.FullName, a.DepartmentID, d.DepartmentName
FROM
	Account a
INNER JOIN
	Department d
    ON
    a.DepartmentID = d.DepartmentID;
    
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010

-- SELECT 
-- 	*
-- FROM
-- 	Account
-- WHERE
-- 	CreateDate > '2010/12/20';

SELECT
	a.AccountID, a.Email, a.UserName, a.FullName, d.DepartmentName, p.PositionName, a.CreateDate
FROM 
	Account a
INNER JOIN Department d
	ON
	a.DepartmentID = d.DepartmentID 
INNER JOIN Position p
	ON
    a.PositionID = p.PositionID
WHERE CreateDate > '2010/12/20';

--- Question 3: Viết lệnh để lấy ra tất cả các developer

SELECT 
	a.AccountID, a.FullName, p.PositionName
FROM
	Account a 
INNER JOIN
	Position p
    ON
    a.PositionID = p.PositionID
WHERE PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có > 3 nhân viên

SELECT 
	a.DepartmentID, d.DepartmentName, COUNT(a.DepartmentID) AS SoLuong
FROM
	Account a 
INNER JOIN
	Department d
    ON
    a.DepartmentID = d.DepartmentID
GROUP BY a.DepartmentID
HAVING COUNT(a.DepartmentID) >= 2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT q.QuestionID, q.Content, COUNT(e.QuestionID) AS SoLanDung
FROM ExamQuestion e
INNER JOIN Question q
	ON
    e.QuestionID = q.QuestionID
GROUP BY e.QuestionID
ORDER BY COUNT(e.QuestionID) DESC
LIMIT 3;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

SELECT c.CategoryID, c.CategoryName, COUNT(q.CategoryID) AS SoLuong
FROM Question q
INNER JOIN CategoryQuestion c 
ON q.CategoryID = c.CategoryID
GROUP BY q.CategoryID
ORDER BY COUNT(q.CategoryID) DESC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT e.QuestionID, q.Content, COUNT(e.QuestionID) AS SoLuongTrongExam
FROM ExamQuestion e
INNER JOIN Question q
	ON e.QuestionID = q.QuestionID
GROUP BY e.QuestionID
ORDER BY COUNT(e.QuestionID) DESC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất

SELECT q.QuestionID, q.Content, COUNT(a.QuestionID) AS SoCauTraLoiMax
FROM Answer a 
INNER JOIN Question q 
	ON a.QuestionID = q.QuestionID
GROUP BY a.QuestionID
-- HAVING COUNT(a.QuestionID)
ORDER BY COUNT(a.QuestionID) DESC LIMIT 3;

-- Question 9: Thống kê số lượng account trong mỗi group

SELECT g.GroupID, g.GroupName, COUNT(g.GroupID) AS SoLuongAccount
FROM GroupAccount h
INNER JOIN Groupp g
	ON h.GroupID = g.GroupID
GROUP BY g.GroupID
ORDER BY COUNT(g.GroupID) DESC;

-- Question 10: Tìm chức vụ có ít người nhất

SELECT p.PositionID, p.PositionName, COUNT(a.PositionID) AS ChucVuCoItNguoiNhat
FROM Account a 
INNER JOIN Position p
	ON a.PositionID = p.PositionID
GROUP BY a.PositionID
ORDER BY COUNT(a.PositionID) ASC;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM










































