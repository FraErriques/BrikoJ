select * from primedata;
call public."usp_primedata_TRUNC"();

call public."usp_primedata_insert"(13);
select * from public."primedata_load_atmaxordinal"();
select * from public."primedata_load_multi"(2,4);