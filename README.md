# DSL-Jobs

For these jobs you need to first create a freestyle job in jenkins with naming convention seed and reference the seed.groovy file in job which further create all the required jenkins jobs for you ,So basically it act as the parent for all the job created in jenkins and its benefits is that if you lost your jenkins server you can create the same job in another jenkins node and by running it will create the same jobs for you in any of the jenkins server.

# About this project (What it does ?)

So, here we assume that you are working for a 'demo' project and you have 'n' number of jobs for that particular demo project so as a best a practice here our automation will create a folder in your jenkins home path and inside that your jobs will be created. You can further create this structure more densed by adding a folder in your seed.groovy.


# Summary

