@echo off
   set PGUSER=postgres
   SET PGPASSWORD=postgres
   echo on
   C:\Postgres\bin\psql.exe -h localhost -p 5432 -d pandemicstats -U postgres -f C:\Users\duduc\OneDrive\BackupPostgres\pandemicstats_04-12-2021.backup
pause