#Dockerfile的内容：
#项目所依赖的jdk镜像
FROM java:16
#将maven构建好的jar添加到镜像中，第二个为别名
ADD target/*.jar app.jar
#暴露的端口号(和项目端口号等同)
EXPOSE 8080
#镜像所执行的命令
ENTRYPOINT ["java","-jar","/app.jar"]