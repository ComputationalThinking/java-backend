# 开发流程

* 1.clone代码

  选择一个文件夹(这个文件夹放项目)，右键选择Git Bash Here进入git命令行,输入git clone https://github.com/ComputationalThinking/java-backend.git 

* 2.切换到项目根目录

  cd java-backend

* 3.切换dev分支

  git checkout -b dev origin/dev

* 4.推拉代码

  * 开发前拉取最新代码
    * git pull origin dev//同步远程dev分支的代码到本地
  * 开发后提交自己的代码
    * git status
    * git add .
    * git commit -m "注释"
    * git push origin dev

  

   	