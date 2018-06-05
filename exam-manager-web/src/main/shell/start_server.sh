#!/bin/bash

env=sep


function usage()
{
    echo "migration 1.0"
    echo ""
    echo "./start_server.sh"
    echo "\t-e --env sep or rc or  production"
    echo ""
}

SNODE="0"
SIP=""

SPORT=6666

while [ "$1" != "" ]; do
    PARAM=`echo $1 | awk -F= '{print $1}'`
    VALUE=`echo $1 | awk -F= '{print $2}'`
    case ${PARAM} in
        -h | --help)
            usage
            exit
            ;;
        *)
            echo "ERROR: unknown parameter \"$PARAM\""
            usage
            exit 1
            ;;
    esac
    shift
done


bin=`dirname "$0"`
BASEDIR=`cd "$bin/.."; pwd`

export BASEDIR

cd ${BASEDIR}/bin

source ./common.sh

cd ${BASEDIR}

CLASSPATH=${BASEDIR}/conf/:${CLASSPATH}


RPC_HEAP_OPTS="-Xmx2g -Xms1g "


echo "starting process..."

nohup ${JAVA} ${JAVA_OPTS}  ${RPC_HEAP_OPTS} ${GC_OPTS} -classpath ${CLASSPATH} -Dfile.encoding=UTF-8 -Dlog.home=${LOG_DIR} -Djava.security.egd=file:/dev/./urandom  -Djgroups.bind_addr=${IP}  ${MAIN_CLASS} >> ${LOG_DIR}/stdout.log 2>&1 &


