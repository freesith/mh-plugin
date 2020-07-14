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
        System.out.println("111")
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        System.out.println("2222")
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "interceptors", "()Ljava/util/List;", false);
        System.out.println("3333")
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "size", "()I", true);
        System.out.println("4444")
        mv.visitInsn(Opcodes.ICONST_1);
        System.out.println("5555")
        mv.visitInsn(Opcodes.ISUB);
        mv.visitVarInsn(Opcodes.ISTORE, 2);
        Label l2 = new Label();
        mv.visitLabel(l2);
        System.out.println("6666")
        mv.visitFrame(Opcodes.F_FULL, 3, ["okhttp3/OkHttpClient",'''okhttp3/OkHttpClient$Builder''',Opcodes.INTEGER] as Object[], 0, [] as Object[]);
        System.out.println("7777")
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        Label l3 = new Label();
        System.out.println("222")
        mv.visitJumpInsn(Opcodes.IFLT, l3);
        Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(9, l4);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "interceptors", "()Ljava/util/List;", false);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;", true);
        mv.visitTypeInsn(Opcodes.CHECKCAST, "okhttp3/Interceptor");
        mv.visitVarInsn(Opcodes.ASTORE, 3);
        Label l5 = new Label();
        mv.visitLabel(l5);
        System.out.println("333")
        mv.visitLineNumber(10, l5);
        mv.visitVarInsn(Opcodes.ALOAD, 3);
        mv.visitTypeInsn(Opcodes.INSTANCEOF, "com/freesith/manhole/MockInterceptor");
        Label l6 = new Label();
        mv.visitJumpInsn(Opcodes.IFEQ, l6);
        Label l7 = new Label();
        mv.visitLabel(l7);
        System.out.println("444")
        mv.visitLineNumber(11, l7);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "interceptors", "()Ljava/util/List;", false);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "remove", "(I)Ljava/lang/Object;", true);
        mv.visitInsn(Opcodes.POP);
        mv.visitLabel(l6);
        mv.visitLineNumber(8, l6);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitIincInsn(2, -1);
        mv.visitJumpInsn(Opcodes.GOTO, l2);
        mv.visitLabel(l3);
        mv.visitLineNumber(14, l3);
        mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, '''okhttp3/OkHttpClient$Builder''', "interceptors", "()Ljava/util/List;", false);
        mv.visitTypeInsn(Opcodes.NEW, "com/freesith/manhole/MockInterceptor");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/freesith/manhole/MockInterceptor", "<init>", "()V", false);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);
        mv.visitInsn(Opcodes.POP);
        mv.visitLocalVariable("interceptor", "Lokhttp3/Interceptor;", null, l5, l6, 3);
        mv.visitLocalVariable("i", "I", null, l2, l3, 2);
        mv.visitMaxs(3, 4);
    }
}