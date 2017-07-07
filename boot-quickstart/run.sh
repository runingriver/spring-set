#!/usr/bin/env bash

#命令行格式 ./run.sh start|stop|status|restart [appName] [boot args]

#为方便使用,请修改下面三个参数,免去每次start,填写参数麻烦
APP_NAME="boot-quickstart"
RUN_ARGS="--app.path=/home/q/www/quickstart --spring.profiles.active=dev"
JVM_ARGS="-XX:MaxPermSize=128m -XX:+DisableExplicitGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./logs/gc.log"

if [ ${2} -a -n ${2} ]
then
    APP_NAME=${2}
fi

if [ ${3} -a -n ${3} ]
then
    RUN_ARGS=${3}
fi

HELP(){
    echo "格式: sudo ./run.sh start|stop|status|restart [appName] [spring-boot args]"
    echo "start 参数: [appName] [spring-boot args]选填,可以修改shell中APP_NAME和RUN_ARGS变量"
    echo "eg: sudo ./run.sh start boot-quickstart --spring.profiles.active=prd --server.port=9191"
    echo "eg: sudo ./run.sh status"
}


PID="${APP_NAME}.pid"
START(){
    echo "APP_NAME:${APP_NAME}"
    echo "RUN_ARGS:${RUN_ARGS}"
    echo "JVM_ARGS:${JVM_ARGS}"
    eval `rm -f ${PID}`
    nohup java ${JVM_ARGS} -jar ${APP_NAME}.jar ${RUN_ARGS} >/dev/null 2>&1 &
    echo $! > ${PID}
    echo "${APP_NAME} Start Success pid:$! "
}

STOP(){
    pid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${pid} ]; then
        echo "Stop Process ${pid}..."
        kill -15 ${pid}
    fi
    sleep 5
    pid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${pid} ]; then
        echo "Kill Process ${pid}..."
        kill -9 ${pid}
    else
        echo "Stop Success!"
    fi
    eval `rm -f ${PID}`
}

STATUS(){
    pid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
    if [ ${pid} ]; then
        echo "App is running pid: ${pid}."
    else
        echo "App is NOT running."
    fi
}

RESTART(){
    STOP
    sleep 2
    START
}

case ${1} in
    start) START ;;
    stop) STOP ;;
    status) STATUS ;;
    restart) RESTART ;;
    *) HELP;;
esac

exit 0
