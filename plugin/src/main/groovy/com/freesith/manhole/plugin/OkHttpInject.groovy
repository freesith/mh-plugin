package com.freesith.manhole.plugin

import javassist.ClassPool
import javassist.CtClass
import javassist.CtConstructor;

public class OkHttpInject {
    static ClassPool classPool = ClassPool.default

    static byte[] inject(InputStream inputStream) {
        def clazz = classPool.makeClass(inputStream)
        if (clazz.frozen) {
            clazz.defrost()
        }
        def constructor = clazz.getConstructor('''(Lokhttp3/OkHttpClient$Builder;)V''')
        if (constructor != null) {
            def code = '''
        boolean addedMock = false;
        int size = $1.interceptors().size();
        if (size > 0) {
            for (okhttp3.Interceptor interceptor: $1.interceptors()) {
                if (interceptor instanceof com.freesith.manhole.MockInterceptor) {
                    addedMock = true;
                    break;
                }
            }
        }
        if (!addedMock) {
            $1.addInterceptor(new com.freesith.manhole.MockInterceptor());
        }
'''
            constructor.insertBeforeBody(code)
            return clazz.toBytecode()
        }
    }
}
