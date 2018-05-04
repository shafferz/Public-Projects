using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WinManager : Pathfinding
{
	public GameObject player;
	private GridPlayer p;
	Animator anim;
	public GameObject bosco;
	private Bosco b;

	void Awake()
	{
		anim = GetComponent<Animator>();
		bosco = GameObject.FindGameObjectWithTag ("Bosco");
		b = bosco.GetComponent<Bosco> ();
		player = GameObject.FindGameObjectWithTag ("Player");
		p = player.GetComponent<GridPlayer> ();
	}


	void Update()
	{
		if (b.active)
		{
			anim.SetTrigger("Win");
			//p.whateverYouWant = 0f;
		}
	}
}