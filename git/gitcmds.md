## Git command reference

### Git log cmd
`git log -n`: lists last n commits from HEAD

`git log --oneline --decorate`: lists all commits from HEAD with oneline 7 byte sha/commit message

`git log --since="1 week ago"` : lists all commits done since last 1 week till HEAD

`git log --grep="jenkins"` : lists all commits with "jenkins" regex in commit message

`git log --oneline --decorate master..dev` : lists all commits which are present in dev but not in master branch

`git log master...dev`: lists all commits present in either master or dev but not in both

`git log --oneline --decorate --no-merges` : list all commits except merge commits

`
### Git reset cmd

`git reset --soft <commitid>` : reset current HEAD to given commit . all changes after commit are preserved in staging area
 
`git reset --mixed < commitid>` : reset current HEAD to given commit . all changes after commit are left untracked.
 
`git reset --hard <commitid>` : reset current HEAD to given commit. all changes after that commit are removed


### Git internals

Refer git object model [Git Object Model](https://thoughtbot.com/upcase/videos/git-object-model).

***Use below commands inside git repo***

`echo "code java" | git hash-object --stdin -w` : creates sha1 id for input and writes blob to .git/objects/

`git cat-file -t <sha1>` : tells the type of git object referred by sha1 e.g. blob/commit/tree

`git cat-file -p <sha1>` : pretty prints the content of git object referred by sha1

`git count-objects` : tells total number of objects in .git



### Branch Deletion cmds

> Refer gir branch deletion link https://stackoverflow.com/questions/2003505/how-do-i-delete-a-git-branch-locally-and-remotely


### Git stash cmd

> git stash  : this cmd creates entry of current working directory/index and pushes to stash with HEAD set to clean state

> git stash only records tracked files in git. 

> Use --include-untracked to add untracked files in stash

> git stash pop 0 : applies stash entry stash@{0} to current branch HEAD

> use --keep-index flag to avoid adding staged files in stash entry
