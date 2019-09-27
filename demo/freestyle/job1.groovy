freeStyleJob('demo/freestyle/job1') {
    label('prod')  //jenkins-slave on which you want to run job
    logRotator(numToKeep = 10)
    parameters {
        stringParam("REGION","us-east-1", "Region of cert")
    }
    scm {
        git {
            remote {
                url("https://github.com/chandraprakashdwivedi/DSL-Jobs.git")
                credentials('my-pat-token-cred')
            }
            branch('master')
        }
    }
    steps {
        shell('''#!/bin/bash
        python -u script/hello.py  
        ''')
    }
    publishers {
        mailer('abc@gmail.com', false, false)
    }
}
