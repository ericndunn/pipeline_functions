//@Library('my-shared-libs@master')_
// evenOrOdd(currentBuild.getNumber())
@Library('my-shared-libs@feature/Test_Functions')_
pipeline {
    agent { label 'master' }
    stages {
        stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
        }
        stage ('buildPlugin build') {
            // agent { label 'master' }
            steps {
                script { 
                    buildPlugin name: 'mvnexamples'
                }
            }
        }
        stage('test') {
            agent { label 'windows' }
            steps {
                sayHello 'Joe'
            }
        }
        stage('Environment variables') {
            agent { label 'windows' }            
            steps {
                bat('set')
             }
        }
        stage('Version of PS') {
            agent { label 'windows' }           
            steps {
                powershell label: '', script: '$PSVersionTable'
            }
        }
        stage('Get-ChildItem') {
            agent { label 'windows' }
            steps {
                powershell label: '', script: '''Get-ChildItem |
                Sort-Object -Property LastWriteTime, Name |
                Format-Table -Property LastWriteTime, Name'''
            }
        }
        stage('Get-CimInstance') {
            agent { label 'windows' }
            steps {
                powershell label: '', script: '''Get-CimInstance -ClassName Win32_QuickFixEngineering -ComputerName . -Property HotFixID'''
            }
        }
    }
}

