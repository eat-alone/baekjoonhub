-- 코드를 입력하세요
SELECT i.ANIMAL_ID,i.ANIMAL_TYPE,i.NAME
from animal_ins i join animal_outs o
on i.ANIMAL_ID = o.ANIMAL_ID
where i.sex_upon_intake like '%Intact%' and (o.sex_upon_outcome like '%Spayed%' or o.sex_upon_outcome like '%Neutered%');