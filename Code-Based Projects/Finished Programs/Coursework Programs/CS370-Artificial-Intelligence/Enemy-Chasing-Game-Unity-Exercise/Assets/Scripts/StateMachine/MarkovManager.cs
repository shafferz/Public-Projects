using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class MarkovManager : MonoBehaviour
{
	public static int pat;
	public static int alert;
	public static int chase;
	public static int trans;
	public static int reward;

	Text text;

	void Awake ()
	{
		text = GetComponent <Text> ();
		pat = StatePatternEnemy.patrolCount;
		alert = StatePatternEnemy.alertCount;
		chase = StatePatternEnemy.chaseCount;
		trans = StatePatternEnemy.transCount;
		reward = StatePatternEnemy.rewardScore;
	}

	void Update ()
	{
		text.text = "Reward Count: " + reward;
		text.text += "Patrol Count: " + pat;
		text.text += "Alert Count: " + alert;
		text.text += "Chase Count: " + chase;
		text.text += "Transitions: " + trans;
	}
}