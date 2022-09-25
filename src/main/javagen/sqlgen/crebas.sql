-- ============================================================
--   SGBD      		  :  H2                     
-- ============================================================

-- ============================================================
--   Drop                                       
-- ============================================================
drop table IF EXISTS MOVIE cascade;
drop sequence IF EXISTS SEQ_MOVIE;




-- ============================================================
--   Sequences                                      
-- ============================================================
create sequence SEQ_MOVIE
	start with 1000 cache 20; 


-- ============================================================
--   Table : MOVIE                                        
-- ============================================================
create table MOVIE
(
    MOV_ID      	 NUMERIC     	not null,
    TITLE       	 TEXT        	not null,
    constraint PK_MOVIE primary key (MOV_ID)
);

comment on column MOVIE.MOV_ID is
'ID';

comment on column MOVIE.TITLE is
'Titre';



