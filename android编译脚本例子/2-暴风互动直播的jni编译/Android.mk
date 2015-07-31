#Stream库的安卓版本编译脚本
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SHORT_COMMANDS := true

#初始化各个预编译库的路径
#初始化需要引用的绝对路径
#LIBCURL_SRC_PATH := $(LOCAL_PATH)/libcurl








#引用动态库
LOCAL_MODULE := libasynccore
LOCAL_SRC_FILES := $(LOCAL_PATH)/../depends/libasynccore/lib/libasynccored.a
include $(PREBUILT_STATIC_LIBRARY)
include $(CLEAR_VARS)

LOCAL_MODULE := libevent
LOCAL_SRC_FILES := $(LOCAL_PATH)/../depends/libevent/lib/libevent.a
include $(PREBUILT_STATIC_LIBRARY)
include $(CLEAR_VARS)


LOCAL_MODULE := libevent_core
LOCAL_SRC_FILES := $(LOCAL_PATH)/../depends/libevent/lib/libevent_core.a
include $(PREBUILT_STATIC_LIBRARY)
include $(CLEAR_VARS)


LOCAL_MODULE := libevent_extra
LOCAL_SRC_FILES := $(LOCAL_PATH)/../depends/libevent/lib/libevent_extra.a
include $(PREBUILT_STATIC_LIBRARY)
include $(CLEAR_VARS)


LOCAL_MODULE := libevent_pthreads
LOCAL_SRC_FILES := $(LOCAL_PATH)/../depends/libevent/lib/libevent_pthreads.a
include $(PREBUILT_STATIC_LIBRARY)
include $(CLEAR_VARS)



#ar预编译的库
#LOCAL_MODULE := libcurl
#LOCAL_SRC_FILES := $(LIBCURL_SRC_PATH)/lib/libcurl.a
#include $(PREBUILT_STATIC_LIBRARY)
#include $(CLEAR_VARS)






#开始编译源码
LOCAL_MODULE := libstream_transfer
#设置头文件引用路径
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../../../include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../depends/libasynccore/include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../depends/libevent/include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../../../src

#源码路径
STREAM_SRC_PATH := $(LOCAL_PATH)/../../../src




#引用源码文件
MY_FILES := $(wildcard $(STREAM_SRC_PATH)/*.cpp)
MY_FILES += $(wildcard $(STREAM_SRC_PATH)/*.c)
LOCAL_SRC_FILES += $(MY_FILES)
#$(warning $(MY_FILES))


#设置编译选项
LOCAL_CPPFLAGS += -DANDROID
LOCAL_CPPFLAGS += -frtti

LOCAL_STATIC_LIBRARIES += libasynccore
LOCAL_STATIC_LIBRARIES += libevent
LOCAL_STATIC_LIBRARIES += libevent_core
LOCAL_STATIC_LIBRARIES += libevent_extra
LOCAL_STATIC_LIBRARIES += libevent_pthreads

LOCAL_LDLIBS += -Wl,-Bstatic -Wl,-Bdynamic



#引用其他的库文件


#指定导出符号文件




#编译生成动态库
include $(BUILD_SHARED_LIBRARY)
