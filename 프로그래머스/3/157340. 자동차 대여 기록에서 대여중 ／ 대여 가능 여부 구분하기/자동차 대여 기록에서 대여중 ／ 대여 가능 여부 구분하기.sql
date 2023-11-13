-- 코드를 입력하세요
select car_id,
case
    when('2022-10-16' between start_date and end_date) then '대여중'
    when('2022-10-16' = end_date) then '대여중'
    else '대여 가능'
end as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where end_date >= '2022-10-16'
group by car_id
order by car_id desc

