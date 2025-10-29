-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

CREATE VIEW View_Account_Sale AS(
SELECT 
    a.AccountID, 
    a.FullName, 
    a.Email, 
    d.DepartmentName
FROM 
    account a
INNER JOIN department d 
    ON a.DepartmentID = d.DepartmentID
WHERE 
    d.DepartmentName = 'Sale');
