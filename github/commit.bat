@echo off
git init
git add .
git config --global user.email "platlwlee1@gmail.com"
git config --global user.name "devlone64"
git remote add origin https://github.com/devlone64/BukkitTemplate.git
git commit -m “Commit Update”
git push origin master
echo Successfully for commit!
pause>nul
cls
exit