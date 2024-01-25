mysqldump -uroot -p1234 uniselect --extended-insert=FALSE > uniselect.sql && echo "I dump uniselect database successfully !" || echo "failure"
timeout /t 1
