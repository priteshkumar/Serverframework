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
 
`git reset --hard <commitid>` : reset current HEAD to given commit. all changes after that commit are removed.
