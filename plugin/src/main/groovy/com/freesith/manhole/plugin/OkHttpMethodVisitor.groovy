package com.freesith.manhole.plugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class OkHttpMethodVisitor extends MethodVisitor {

    OkHttpMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM4, mv)
    }

    @Override
    void visitCode() {
        super.visitCode()
        mv.visitVarInsn(Opcodes.ALOAD, 1)
        mv.visitTypeInsn(Opcodes.NEW, "com/freesith/manhole/MockInterceptor")
        mv.visitInsn(Opcodes.DUP)
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/freesith/manhole/MockInterceptor", "<init>", "()V", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "addInterceptor", '''(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;''', false)
        mv.visitInsn(Opcodes.POP)
    }
}