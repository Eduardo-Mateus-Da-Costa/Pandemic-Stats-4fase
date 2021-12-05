@echo off

set x=%DATE:~0,2%-%DATE:~3,2%-%DATE:~6,4%
echo %x%
set date=%x%
echo %date%

   set PGUSER=postgres
   set BACKUP_FILE=C:\Users\duduc\OneDrive\BackupPostgres\pandemicstats_%date%.backup
   echo backup file name is %BACKUP_FILE%
   SET PGPASSWORD=postgres
   echo on
   C:\Postgres\bin\pg_dump.exe -h localhost -p 5432 -U postgres -C -F p  -v -f %BACKUP_FILE% pandemicstats
pause