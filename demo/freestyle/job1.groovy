freeStyleJob('demo/freestyle/job1') {
    label('prod')  //jenkins-slave on which you want to run job
    logRotator(numToKeep = 10)
    parameters {
        stringParam("ROLE_NAME","slave-jenkins", "role attached with your slave jenkins")
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
        python -u script/hello.py  --role_name $ROLE_NAME 
        ''')
    }
    publishers {
        mailer('abc@gmail.com', false, false)
    }
}
