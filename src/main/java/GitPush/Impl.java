package GitPush;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.net.URISyntaxException;

/**
 * @Author pan
 * @Date 2020/5/19 17:56
 * @Description
 * @Version 1.0
 **/
public class Impl {
    public static void main(String[] args) throws GitAPIException {
        Git git = Git.cloneRepository().setURI("https://git.uyunsoft.cn/asset/asset-doc.git")
                .setCredentialsProvider(provide())
                .call();
        git.checkout()
                .setCreateBranch(true)
                .setName("R16.30")
                .call();
        File file = git.getRepository().getDirectory();
        String projectPath = file.getParent();
        System.out.println();
    }

    private static UsernamePasswordCredentialsProvider provide() {
        return new UsernamePasswordCredentialsProvider("panyj", "pan7786332rtl");
    }

}
