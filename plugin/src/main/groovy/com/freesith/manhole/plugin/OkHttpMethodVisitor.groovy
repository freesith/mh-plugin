package com.freesith.manhole.plugin

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class OkHttpMethodVisitor extends MethodVisitor {

    OkHttpMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM4, mv)
    }

    @Override
    void visitCode() {
        super.visitCode()

//        mv.visitVarInsn(Opcodes.ALOAD, 1)
//        mv.visitTypeInsn(Opcodes.NEW, "com/freesith/manhole/MockInterceptor")
//        mv.visitInsn(Opcodes.DUP)
//        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/freesith/manhole/MockInterceptor", "<init>", "()V", false)
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "addInterceptor", '''(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;''', false)
//        mv.visitInsn(Opcodes.POP)


        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLineNumber(12, l1);
        mv.visitInsn(Opcodes.ICONST_0);
        mv.visitVarInsn(Opcodes.ISTORE, 2);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(13, l2);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "okhttp3/OkHttpClient$Builder", "interceptors", "()Ljava/util/List;", false);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "iterator", "()Ljava/util/Iterator;", true);
        mv.visitVarInsn(Opcodes.ASTORE, 3);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitFrame(Opcodes.F_FULL, 4, new Object[4]{"okhttp3/OkHttpClient"; "okhttp3/OkHttpClient$Builder"; Opcodes.INTEGER; "java/util/Iterator"}, 0, new Object[4]);
        mv.visitVarInsn(Opcodes.ALOAD, 3);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/Iterator", "hasNext", "()Z", true);
        Label l4 = new Label();
        mv.visitJumpInsn(Opcodes.IFEQ, l4);
        mv.visitVarInsn(Opcodes.ALOAD, 3);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/Iterator", "next", "()Ljava/lang/Object;", true);
        mv.visitTypeInsn(Opcodes.CHECKCAST, "okhttp3/Interceptor");
        mv.visitVarInsn(Opcodes.ASTORE, 4);
        Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLineNumber(14, l5);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitTypeInsn(Opcodes.INSTANCEOF, "com/freesith/manhole/MockInterceptor");
        Label l6 = new Label();
        mv.visitJumpInsn(Opcodes.IFEQ, l6);
        Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(15, l7);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitVarInsn(Opcodes.ISTORE, 2);
        Label l8 = new Label();
        mv.visitLabel(l8);
        mv.visitLineNumber(16, l8);
        mv.visitJumpInsn(Opcodes.GOTO, l4);
        mv.visitLabel(l6);
        mv.visitLineNumber(18, l6);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitJumpInsn(Opcodes.GOTO, l3);
        mv.visitLabel(l4);
        mv.visitLineNumber(19, l4);
        mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        Label l9 = new Label();
        mv.visitJumpInsn(Opcodes.IFNE, l9);
        Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(20, l10);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitTypeInsn(Opcodes.NEW, "com/freesith/manhole/MockInterceptor");
        mv.visitInsn(Opcodes.DUP);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/freesith/manhole/MockInterceptor", "<init>", "(Lokhttp3/OkHttpClient;)V", false);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "okhttp3/OkHttpClient$Builder", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", false);
        mv.visitInsn(Opcodes.POP);
//        mv.visitLabel(l9);
//        mv.visitLineNumber(22, l9);
//        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//        mv.visitInsn(Opcodes.RETURN);
        Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLocalVariable("interceptor", "Lokhttp3/Interceptor;", null, l5, l6, 4);
        mv.visitLocalVariable("this", "Lokhttp3/OkHttpClient;", null, l0, l11, 0);
        mv.visitLocalVariable("builder", "Lokhttp3/OkHttpClient$Builder;", null, l0, l11, 1);
        mv.visitLocalVariable("addedMock", "Z", null, l2, l11, 2);
        mv.visitMaxs(4, 5);

    }
}