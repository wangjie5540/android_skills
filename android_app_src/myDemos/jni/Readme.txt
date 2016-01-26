编写jni的技巧总结
1、用env->DeleteLocalRef函数，删除所有没有的LocalRef，避免内存泄漏（之前被坑过）
2、