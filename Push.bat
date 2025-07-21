@echo off
git status
timeout /t 2

git add *
timeout /t 2

git commit -m "committed"
timeout /t 2

git push origin master
timeout /t 2
