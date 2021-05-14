package fleur.de.peau.git.flow;

public class GitFlowTestForFeature {

    public void forFeature(String platform) {

        boolean isScrollLock = true;
        System.out.println(!isScrollLock + "hello, world!");
        System.out.println(isScrollLock);


        if(platform.equals("OPENSHIFT")) {
            System.out.println("platform is ...!");
        }


    }
}
