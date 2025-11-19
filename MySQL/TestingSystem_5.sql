-- Cú pháp 
/*
CREATE VIEW
CREATE VIEW view_name AS
	SELECT	column_name_1, column_name_2 
	FROM		table_name 
	…;
SELECT data 
SELECT 	column_name_1, column_name_2 
FROM 	view_name
DROP VIEW
DROP VIEW IF EXISTS view_name
*/

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

SELECT a.AccountID, a.Email, a.FullName, a.DepartmentID, d.DepartmentName FROM Account a 
INNER JOIN Department d
	ON a.DepartmentID = d.DepartmentID
WHERE d.DepartmentName = 'Sale';

CREATE VIEW view_AccountDerpartment AS (
	SELECT 
		a.AccountID, 
		a.Email, 
        a.FullName, 
        a.DepartmentID, 
        d.DepartmentName 
	FROM Account a 
	INNER JOIN Department d
		ON a.DepartmentID = d.DepartmentID
	WHERE d.DepartmentName = 'Sale'
);

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

WITH cte_MaxCountByGroup AS (
	SELECT COUNT(*) AS SoLuong FROM groupaccount gr 
    GROUP BY gr.AccountID
)

SELECT 
    a.AccountID,
    a.FullName,
    COUNT(gr.AccountID) AS SoLuong 
FROM Account a 
INNER JOIN GroupAccount gr 
	ON a.AccountID = gr.AccountID
GROUP BY gr.AccountID
HAVING COUNT(gr.AccountID) = (SELECT MAX(SoLuong) AS SLMAX  FROM cte_MaxCountByGroup);

CREATE VIEW view_AccountjoinGrMax AS (
	WITH cte_MaxCountByGroup AS (
		SELECT COUNT(*) AS SoLuong FROM groupaccount gr 
		GROUP BY gr.AccountID
	)

	SELECT 
		a.AccountID,
		a.FullName,
		COUNT(gr.AccountID) AS SoLuong 
	FROM Account a 
	INNER JOIN GroupAccount gr 
		ON a.AccountID = gr.AccountID
	GROUP BY gr.AccountID
	HAVING COUNT(gr.AccountID) = (SELECT MAX(SoLuong) AS SLMAX  FROM cte_MaxCountByGroup)
);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi

SELECT * FROM question q 
WHERE length(Content) > 18;

CREATE OR REPLACE VIEW view_DeleteConten AS (
	SELECT * FROM Question q 
    WHERE length(Content) > 180
);
SELECT * FROM view_DeleteConten;
DELETE FROM view_DeleteConten;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất 

WITH cte_MaxAccountDepartment AS (
	SELECT COUNT(*) AS SOLUONG 
    FROM Account a 
    GROUP BY a.DepartmentID
)

SELECT 
	a.DepartmentID, 
	d.DepartmentName, 
    COUNT(a.DepartmentID) AS SoLuongMAX 
FROM Account a 
INNER JOIN Department d 
	ON a.DepartmentID = d.DepartmentID 
GROUP BY a.DepartmentID
HAVING COUNT(a.DepartmentID) = (
								SELECT MAX(SOLUONG) FROM cte_MaxAccountDepartment);
                                
CREATE VIEW view_MaxNhanVienDepartment AS (
	WITH cte_MaxAccountDepartment AS (
		SELECT COUNT(*) AS SOLUONG 
		FROM Account a 
		GROUP BY a.DepartmentID
	)

	SELECT 
		a.DepartmentID, 
		d.DepartmentName, 
		COUNT(a.DepartmentID) AS SoLuongMAX 
	FROM Account a 
	INNER JOIN Department d 
		ON a.DepartmentID = d.DepartmentID 
	GROUP BY a.DepartmentID
	HAVING COUNT(a.DepartmentID) = (
									SELECT MAX(SOLUONG) FROM cte_MaxAccountDepartment)
);


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo

SELECT q.QuestionID, q.Content, a.AccountID, a.FullName FROM Question q 
INNER JOIN Account a 
	ON q.CreatorID = a.AccountID
WHERE a.FullName LIKE "Nguyen%";

CREATE VIEW view_AnswerNguyen AS (
	SELECT 
		q.QuestionID, 
        q.Content, 
        a.AccountID, 
        a.FullName 
	FROM Question q 
	INNER JOIN Account a 
		ON q.CreatorID = a.AccountID
	WHERE a.FullName LIKE "Nguyen%"
);























































