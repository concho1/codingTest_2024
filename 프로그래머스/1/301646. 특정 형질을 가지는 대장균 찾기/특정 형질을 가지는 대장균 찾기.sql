-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT FROM ECOLI_DATA 
WHERE (
    (   
        GENOTYPE % 2 = 1          -- 1번 형질 O
        OR 
        (GENOTYPE >> 2) % 2 = 1   -- 3번 형질 O
    )
    AND
    (GENOTYPE >> 1) % 2 = 0       -- 2번 형질 X
);