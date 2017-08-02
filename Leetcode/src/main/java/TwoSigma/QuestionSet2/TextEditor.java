package TwoSigma.QuestionSet2;

/**
 * Created by cc on 2016/8/28.
 */
public class TextEditor {

    //1 Linked list, n
    //2 Tree, leaf store each character, needs to be re-balanced, non leaf store index, left side <= root, right > root
    //When update tree, if update left, right side all non-leaf need to be shift. No difference with Linked list
    //3 save time, non leaf store relative position, to the left. So update left, only update root. update right do nothing.
    //4 save space, leaf store more than 1 character, say 8, exceed, we split.
}
