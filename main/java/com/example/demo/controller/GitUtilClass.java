package com.example.demo.controller;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.Test;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.io.File;
import java.io.IOException;

//public class GitUtilClass {
////    public static String localRepoPath = "C:/Users/limeng/IdeaProjects/Votedemo/src";
////    public static String localRepoGitConfig = "C:/Users/limeng/IdeaProjects/Votedemo/src/.git";
//    //远程库路径
//    public static String remoteRepoURI = "http://gitlab.dobest.com/web/hbhk_shop";
//    //下载已有仓库到本地路径
//    public static String localCodeDir = "E:/hbhk";
//    File localCodeDirFile = (File) localCodeDir;
//
//    @Test
//    public void testClone() throws IOException, GitAPIException {
//        //设置远程服务器上的用户名和密码
//        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
//                UsernamePasswordCredentialsProvider("limeng","Lm123456");
//
//        //克隆代码库命令
//        CloneCommand cloneCommand = Git.cloneRepository();
//
//        Git git= cloneCommand.setURI(remoteRepoURI) //设置远程URI
//                .setBranch("master") //设置clone下来的分支
//                .setDirectory(File(localCodeDir)) //设置下载存放路径
//                .setCredentialsProvider(usernamePasswordCredentialsProvider) //设置权限验证
//                .call();
//
//        System.out.print(git.tag());
//    }
//}
