#!/bin/bash

CUR_DIR=`pwd`
STREAM_TRANSFER_PATH=${CUR_DIR}/project/libstream_transfer
STREAM_TRANSFER_TARGET=${CUR_DIR}/output/libstream_transferd.so
STREAM_TRANSFER_TEST_PATH=${CUR_DIR}/project/test
STREAM_TRANSFER_TEST_TARGET=${CUR_DIR}/output/live_media_encoderd

MAKE_JOBS_NUM=1

if [ $# == 0 ];then
	# build libstream_transferd.so
	cd ${STREAM_TRANSFER_PATH};
	make -k -j ${MAKE_JOBS_NUM};
	cd ${CUR_DIR}
	[ -f STREAM_TRANSFER_TARGET ] && svn info >> STREAM_TRANSFER_TARGET
elif [ $# == 1 ];then
	if [ $1 == 'clean' ];then
		cd ${STREAM_TRANSFER_PATH};
		make clean;
		cd ${STREAM_TRANSFER_TEST_PATH};
		make clean;
	elif [ $1 == 'test' ];then
		# build live_media_encoderd
		cd ${STREAM_TRANSFER_TEST_PATH};
		make -k -j ${MAKE_JOBS_NUM};
		cd ${CUR_DIR}
		[ -f STREAM_TRANSFER_TEST_TARGET ] && svn info >> STREAM_TRANSFER_TEST_TARGET
	else
		echo "$0 or $0 clean"
	fi
fi
