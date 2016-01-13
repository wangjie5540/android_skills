
#system              -> Use the default minimal C++ runtime library.  
#stlport_static      -> Use STLport built as a static library.  
#stlport_shared      -> Use STLport built as a shared library.  
#gnustl_static       -> Use GNU libstdc++ as a static library.
APP_STL := stlport_static
#APP_ABI := armeabi armeabi-v7a 
APP_ABI := armeabi
APP_PLATFORM := android-14
APP_SHORT_COMMANDS := true

#for using c++ features,you need to enable these in your Makefile  
#APP_CPP_FEATURES += exceptions rtti
#APP_CPPFLAGS += -fexceptions  

#这里可以控制版本是否是release
# APP_OPTIM := release OR debug  