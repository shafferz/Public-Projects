using UnityEngine;
using System.Collections;

public class StatePatternEnemy : MonoBehaviour 
{
	public float searchingTurnSpeed = 120f;
	public float searchingDuration = 4f;
	public float sightRange = 20f;
	public Transform[] wayPoints;
	public Transform eyes;
	public Vector3 offset = new Vector3 (0,.5f,0);
	public MeshRenderer meshRendererFlag;
	public static float randVal;
	public static int rewardScore;
	public static int transCount;
	public static int chaseCount;
	public static int alertCount;
	public static int patrolCount;

	[HideInInspector] public Transform chaseTarget;
	[HideInInspector] public IEnemyState currentState;
	[HideInInspector] public ChaseState chaseState;
	[HideInInspector] public AlertState alertState;
	[HideInInspector] public PatrolState patrolState;
	[HideInInspector] public UnityEngine.AI.NavMeshAgent navMeshAgent;

	private void Awake()
	{
		chaseState = new ChaseState (this);
		alertState = new AlertState (this);
		patrolState = new PatrolState (this);

		rewardScore = 0;
		transCount = 0;
		chaseCount = 0;
		alertCount = 0;
		patrolCount = 0;

		randVal = Random.Range (0.0f, 1.0f);
		rewardScore = 0;

		navMeshAgent = GetComponent<UnityEngine.AI.NavMeshAgent> ();
	}

	// Use this for initialization
	void Start () 
	{
		currentState = patrolState;
		patrolCount++;
	}

	// Update is called once per frame
	void Update () 
	{
		currentState.UpdateState ();
	}

	private void OnTriggerEnter(Collider other)
	{
		currentState.OnTriggerEnter (other);
		randVal = Random.Range(0.0f, 1.0f);
	}
}