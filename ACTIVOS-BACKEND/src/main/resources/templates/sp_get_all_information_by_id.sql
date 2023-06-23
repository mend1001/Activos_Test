CREATE PROCEDURE sp_get_all_information_by_id(
in
id int
)
BEGIN
SELECT 
employees.id,
employees.first_name,
employees.last_name,
state.description,
position.charge 
FROM 
payroll.employees
inner join payroll.state on payroll.employees.sta_state = payroll.state.id
inner join payroll.position on payroll.employees.pos_position = payroll.position.id
where employees.id=id;
END
