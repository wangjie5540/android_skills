#=======开始格式
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
#=======加了会变慢,但会解决因为路径太长的编译问题
#LOCAL_SHORT_COMMANDS := true

#=======native模块(可以算为模板)
LOCAL_MODULE    := native_center
LOCAL_SRC_FILES := native_center.cpp
LOCAL_SRC_FILES += audio_codec.cpp
LOCAL_SRC_FILES += video_codec.cpp

#=======配置版本类型
#debug
#LOCAL_CFLAGS += -g -D_DEBUG -DP2P_LOG
#release
#LOCAL_CFLAGS += -O2 -DNDEBUG
#=======配置jni层的日志需要的so
LOCAL_LDLIBS    := -lm -llog
#=======配置头文件目录
LOCAL_C_INCLUDES := sources/foo

#=======引用其他目录的Android.mk文件
#include $(call all-subdir-makefiles)
#include $(CLEAR_VARS)

#=======引用前面定义的静态库
#LOCAL_STATIC_LIBRARIES := libp2p

#=======编译库的类型
include $(BUILD_SHARED_LIBRARY)
#include $(BUILD_STATIC_LIBRARY)  

