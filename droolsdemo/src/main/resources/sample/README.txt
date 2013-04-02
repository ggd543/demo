假设雇员 Employ 有：
      学历信息 eduInfo, 简历信息 resume ,考核信息 annualExam 和奖惩信息  awardPunish
要确定其：
      基本工资 basicSalary,职务工资 dutySalary,分红金额 bonus 和 总工资 totalSalary

规则如下：
(1) 学历决定基本工资(basicSalary): 本科 1500 研究生 2500
(2) 简历决定职务工资 (dutySalary): 技术 2000 管理 4500
(3)年度考核决定分红(bonus):
    分红总金额 1000
    考核结果：优秀 100% （ 1000 ）；良好 90% （ 900 ）；合格 60% （ 600 ）； 不合格 0% （ 0 ）
(4)奖惩决定计算最终工资与(basicSalary + dutySalary + bonus)的比例(salaryPercentage)：
    奖励： * 110% （ +10% ）
    惩罚： * 90% （ -10% ）
    无： * 100% （ 0% ）
(5)计算总工资： totalSalary = (basicSalary + dutySalary + bonus) * salaryPercentage