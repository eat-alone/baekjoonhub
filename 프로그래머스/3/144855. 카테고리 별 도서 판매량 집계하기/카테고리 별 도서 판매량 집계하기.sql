-- 코드를 입력하세요
SELECT b.category, sum(s.sales) as total_sales
from book_sales s join book b
on s.book_id = b.book_id
where sales_date like '2022-01%'
group by category
order by category;


